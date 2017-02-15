
//int n = 10
//List<Integer> list = new ArrayList<>();
//for(int i = 0;i<n;i++){
//    list.add( (2<<i))
//}
//println(list)

(0 ..10).stream().map{2 ** it}.forEach{println it}

