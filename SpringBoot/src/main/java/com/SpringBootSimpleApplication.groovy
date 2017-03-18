package com

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonEncoding
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.databind.SerializationConfig
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.ser.FilterProvider
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpOutputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.util.TypeUtils

import java.lang.reflect.Type

@Slf4j
@SpringBootApplication
class SpringBootSimpleApplication {

    @Bean
    Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder(){
        Jackson2ObjectMapperBuilder
                .json()
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .indentOutput(true)
    }

    @Bean
    HttpMessageConverters httpMessageConverters(){
        new HttpMessageConverters(false,[
                new MappingJackson2HttpMessageConverter(){
                    @Override
                    protected void addDefaultHeaders(HttpHeaders headers, Object o, MediaType contentType) throws IOException {
                        //set headers
                        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
                        if(o instanceof String){
                            o.metaClass.isJson = {
                                try {
                                    new JsonSlurper().parseText o
                                    true
                                }catch (e){
                                    false
                                }
                            }
                            if(!o.isJson()){
                                headers.setContentType(MediaType.TEXT_PLAIN)
                            }
                        }
                    }

                    @Override
                    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                        MediaType contentType = outputMessage.getHeaders().getContentType();
                        JsonEncoding encoding = getJsonEncoding(contentType);
                        JsonGenerator generator = this.objectMapper.getFactory().createGenerator(outputMessage.getBody(), encoding);
                        if(objectMapper.isEnabled(SerializationFeature.INDENT_OUTPUT)){
                            generator.useDefaultPrettyPrinter()
                        }
                        try {
                            if(object instanceof String){
                                generator.writeRaw(object)
                                generator.flush()
                                return
                            }
                            writePrefix(generator, object);

                            Class<?> serializationView = null;
                            FilterProvider filters = null;
                            Object value = object;
                            JavaType javaType = null;
                            if (object instanceof MappingJacksonValue) {
                                MappingJacksonValue container = (MappingJacksonValue) object;
                                value = container.getValue();
                                serializationView = container.getSerializationView();
                                filters = container.getFilters();
                            }
                            if (type != null && value != null && TypeUtils.isAssignable(type, value.getClass())) {
                                javaType = getJavaType(type, null);
                            }
                            ObjectWriter objectWriter;
                            if (serializationView != null) {
                                objectWriter = this.objectMapper.writerWithView(serializationView);
                            }
                            else if (filters != null) {
                                objectWriter = this.objectMapper.writer(filters);
                            }
                            else {
                                objectWriter = this.objectMapper.writer();
                            }
                            if (javaType != null && javaType.isContainerType()) {
                                objectWriter = objectWriter.forType(javaType);
                            }
                            SerializationConfig config = objectWriter.getConfig();
                            if (contentType != null && contentType.isCompatibleWith(TEXT_EVENT_STREAM) &&
                                    config.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
                                objectWriter = objectWriter.with(this.ssePrettyPrinter);
                            }
                            objectWriter.writeValue(generator, value);

                            writeSuffix(generator, object);
                            generator.flush();

                        }
                        catch (JsonProcessingException ex) {
                            throw new HttpMessageNotWritableException("Could not write content: " + ex.getMessage(), ex);
                        }
                    }
                }
        ])
    }
    static void main(String... args) {
        log.info("springboot start ... ")
        SpringApplication.run SpringBootSimpleApplication,args

    }
}
