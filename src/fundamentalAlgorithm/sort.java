package fundamentalAlgorithm;

import sun.awt.image.OffScreenImage;


public class sort {
	/**
	 * @ð������
	 * ������ɴ�С
	 * �Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
	 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û�����������
	 * ������е�Ԫ���ظ����ϵĲ��裬�������һ����
	 * ����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
	 */
	public int[] bubbleSort(int[] arr) {
		int temp = 0;
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = 0; j < len-1-i; j++) {
				if (arr[j] < arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	
	/**
	 * @��������
	 * ������ɴ�С
	 * ͨ��һ�����򽫴������¼�ָ�ɶ����������֣�����һ���ּ�¼�Ĺؼ��־�����һ���ֹؼ���С����ֱ���������ּ�����������ֱ��������������
	 * ���������п���һ�����飬�ѵ����λ�ÿ������ᣬ�����һ���ȣ��������С���������������κδ����������Ժ��ٺ�С���Ƕ˱ȣ�����С�������������󽻻�������ѭ��������һ��������ɣ���߾��Ǳ�����С�ģ��ұ߾��Ǳ������ģ�Ȼ�����÷��η����ֱ�������������������������
	 * 
	 */
	public int[] quickSort(int[] Arr,int low, int high) {
		 int start = low;
		 int end = high;
		 int key = Arr[low];
		 while (end > start) {
			while (end>start && Arr[end]>=key) {//���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
				end--;
				if (Arr[end] <= key) {
					int temp = Arr[end];
					Arr[end] = Arr[start];
					Arr[start] = temp;
				}// of if
				
			}// of while
			while (end>start && Arr[start]<=key) {//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
				start++;
				if (Arr[start]>=key) {
					int temp = Arr[start];
					Arr[start] = Arr[end];
					Arr[end] = temp;
				} // of if
				//��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
			}// of while	
			
			//�ݹ�
			if (start>low) {
				quickSort(Arr, low, start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
			}// of if 
			if (end<high) {
				quickSort(Arr, end+1, high);//�ұ����С��ӹؼ�ֵ����+1�����һ��
			}// of if
			
		 }		 
		
		return Arr;
	}
	
	
	/**
	 * @ѡ������
	 * ��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ�� 
	 * �ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ��
	 *  �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
	 */
	public int[] choseResort(int [] arr) {
		int len = arr.length;//����ĳ���
		int temp = 0; //�м����
		for (int i = 0; i < len; i++) {
			int k = i;//��ȷ����λ��
			//ѡ���Ӧ���ڵ�i��λ�ӵ���
			for (int j = len-1; j < i; j--) {
				if (arr[j]<arr[k]) {
					k = j;
				}// of if
			}// of for j
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;			
		}// of for i		
		return arr;
	}
	
	
	/**
	 * @��������
	 * ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ�ã��Ӻ���ǰ�ҵ�����λ�ú󣩣�ֱ��ȫ������������Ϊֹ��
	 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
     * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�� 
     * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��  
     * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��  
     * ����Ԫ�ز��뵽��λ����  
     * �ظ�����2  
     * ʱ�临�Ӷȣ�O��n^2��
	 */
	public int[] insertSort(int[] arr) {
		int len = arr.length;
		int temp = 0;
		int j = 0;
		for (int i = 0; i < len; i++) {
			temp= arr[i];
			for (j = i; j < 0 && temp<arr[j-1]; j--) {
				arr[j] = arr[j-1];
			}// of for j
			arr[j] = temp;
		}// of for i
		return arr;
	}
	
	/**
	 * @ϣ������
	 * �Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬴����������еļ�¼����������ʱ���ٶ�ȫ���¼��������ֱ�Ӳ�������
	 * ϣ�������ԭ��:���������������Ҫ����Ӵ�С���У��������Ƚ�������з��飬Ȼ�󽫽ϴ�ֵ�Ƶ�ǰ�棬��Сֵ
     * �Ƶ����棬�������������в���������������һ��ʼ���ò���������������ݽ������ƶ��Ĵ���������˵ϣ�������Ǽ�ǿ
     * ��Ĳ�������
     * 
     * ʱ�临�Ӷȣ�O��n^2��.
	 */
	public int[] shellSort(int[] arr) {
		int j = 0;
		int temp = 0;
		//��ÿ�εĲ�������Ϊԭ���İ�
		for (int increment = arr.length/2;increment > 0; increment /= 2) {
			for (int i = increment; i < arr.length; i++) {
				temp = arr[i];
				for (j = i; j>=increment; j -= increment) {
					if (temp>arr[j-increment]) {
						arr[j] = arr[j-increment];
					}else{
						break;
					}// of if....else....
				}// of for j 
				arr[j] = temp;
			}// of for i
		}// of for increment
		return arr;
	}
	
	

	/**
	 * @param main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test bubbleSort
		int[] test = {12,52,9,7,16,6,7,11,-5,22};
		sort aSort = new sort();
		int[] resultBubble = aSort.bubbleSort(test);
		System.out.println("BubbleSort results:");
		for (int i = 0; i < resultBubble.length; i++) {
			System.out.print(resultBubble[i]+" ");
		}// of for bubble
		System.out.println('\n');
		
		int[] reusultQuick = aSort.quickSort(test, 0, test.length-1);
		System.out.println("quickSort results:");
		for (int i = 0; i < reusultQuick.length; i++) {
			System.out.print(reusultQuick[i]+" ");
		}// of for quick
		
		System.out.println("\n\nchoseSort results:");		
		int[] resultChose = aSort.choseResort(test);
		for (int i = 0; i < resultChose.length; i++) {
			System.out.print(resultChose[i]+" ");
		}// of for chose
		
		System.out.println("\n\nInsertSort results:");		
		int[] resultInsert = aSort.insertSort(test);
		for (int i = 0; i < resultInsert.length; i++) {
			System.out.print(resultInsert[i]+" ");
		}// of for chose
		
		System.out.println("\n\nshellSort results:");		
		int[] resultShell = aSort.shellSort(test);
		for (int i = 0; i < resultShell.length; i++) {
			System.out.print(resultShell[i]+" ");
		}// of for chose
		
		

	}// of main()

}// of class sort
