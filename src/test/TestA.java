package test;


public class TestA {
	
	
	public static void main(String args[]) {
		String arr[]= {" "," "," "," "," "};
			for(int i=arr.length-1;i>=0;i--) {
				for(int j=0;j<arr.length;j++) {
					if(i==j) {
						arr[i]="* ";
						System.out.print(arr[j]);
					}else {
						System.out.print(arr[j]);
					}
				}
				System.out.println("");
			}
			for(int i=0;i<arr.length;i++) {
				for(int j =0;j<arr.length;j++) {
					arr[i]=" ";
					System.out.print(arr[j]);
				}
				System.out.println("");
			}
		}
}
