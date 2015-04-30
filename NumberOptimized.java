import java.util.HashMap;


public class NumberOptimized {

	/**
	 * @param args
	 */
	
	public static int size(int n, HashMap<Integer,Integer> list){
		if(list.get(n) != null){
			return list.get(n);
		}

		int currentNum = n;
		if(n != 1) {
			if(n % 2 == 0) {
				n = n/2;
			} else {
				n = 3 * n + 1;
			}
			int size = 1 + size(n, list);
			System.out.println("putting : " + currentNum + " -- " + size);
			list.put(currentNum, size);
			return size;
		} else {
			list.put(n, 1);
			return 1;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time = System.currentTimeMillis();
		HashMap<Integer,Integer> sizeList = new HashMap<Integer,Integer>();
		int maxSize = 0;
		int numWithMaxSize = 0;
		for( int i = 1; i <= 10000; i++){
			size(i,sizeList);
			if(sizeList.get(i) > maxSize) {
				maxSize = sizeList.get(i);
				numWithMaxSize = i;
			}
			System.out.println(i + ":" + sizeList.get(i));
		}
		
		System.out.println( "Num with max size:" + numWithMaxSize);
		System.out.println(System.currentTimeMillis() - time);
		
	}

}
