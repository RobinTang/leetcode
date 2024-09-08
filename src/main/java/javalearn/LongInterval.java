package javalearn;

public class LongInterval {

        public static void main(String[] args) {
            // Scanner input=new Scanner(System.in);
            // String str=input.next();
            System.out.println("hello world");
            int[] arr = {100, 1, 50, 5, 9, 7, 3, 7, 100};

            int head = 0;
            int tail = 0;

            int min = arr[head];
            int max = arr[tail];
            int maxIndex = tail;

            int historyHead = head;
            int historyTail = tail;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < min) {
                    if ((maxIndex - head) > (historyTail - historyHead)) {
                        historyHead = head;
                        historyTail = maxIndex;
                    }
                    head = i;
                    tail = i;
                    min = arr[i];
                    max = arr[i];
                    maxIndex = i;
                } else {
                    if (max < arr[i]) {
                        max = arr[i];
                        maxIndex = i;
                        if ((maxIndex - head) > (historyTail - historyHead)) {
                            historyHead = head;
                            historyTail = maxIndex;
                        }
                    }
                    tail++;
                }
            }
            System.out.println(historyHead + "," + historyTail);
            for (int i = 0; i < arr.length; i++) {
                if (i >= historyHead && i <= historyTail) {
                    System.out.print(arr[i]);
                    System.out.print(",");
                }
            }
        }

}
