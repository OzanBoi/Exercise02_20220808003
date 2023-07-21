public class Exercise02_20220808003 {
    public static void main(String[] args) {
        int[] students = new int[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = random(0, 100);
        }


        // Question 1
        System.out.println("Scores of students:");
        display(students);

        char[] grades = grade(students);

        System.out.println("Grades of students are:");
        display(grades);

        // Question 2
        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random(0, 10);
        }
        display(numbers);
        System.out.println("Average of numbers is: " + average(numbers));

        double[] doubleNumbers = new double[8];
        for (int i = 0; i < doubleNumbers.length; i++) {
            doubleNumbers[i] = random(-0.5, 0.5);
        }
        display(doubleNumbers);
        System.out.println("Average of numbers is: " + average(doubleNumbers));

        // Question 3
        int[] numbers1 = new int[10];
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = random(0, 10, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers are: ");
        display(numbers);

        // Question 4
        int[] numbers2 = new int[10];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = random(0, 10, 0, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers with duplicate values are: ");
        display(numbers2);
        int[] nonDuplicateNumbers = eliminateDuplicates(numbers2);

        System.out.println("Non duplicate numbers");
        display(nonDuplicateNumbers);

        // Question 5
        int[] numbers3 = new int[10];
        for (int i = 0; i < numbers3.length; i++) {
            numbers3[i] = i;
        }
        System.out.println("is array in sorted order: " + isSorted(numbers));
        display(numbers);

        shuffle(numbers);

        System.out.println("is array in sorted order: " + isSorted(numbers));
        display(numbers);

        // Question 6
        int n = 100;
        boolean[] lockers = new boolean[n];
        int[] openLockers = lockers(lockers);

        System.out.println("Open lockers are:");
        display(openLockers);

        System.out.println("for n == 100, open locker amount should be 10: open locker amount: " + openLockers.length);

        n = 1000;
        lockers = new boolean[n];
        openLockers = lockers(lockers);

        System.out.println("for n == 1000, open locker amount should be 31, open locker amount: " + openLockers.length);
   }
   public static char[] grade(int[] students) {
        int highest = getMax(students);
       char[] grades = new char[10];
		for (int i = 0; i < students.length; i++) {
        if (students[i] >= highest - 10)
            grades[i] = 'A';
        else if (students[i] >= highest - 20)
            grades[i] = 'B';
        else if (students[i] >= highest - 30)
            grades[i] = 'C';
        else if (students[i] >= highest - 40)
            grades[i] = 'D';
        else
            grades[i] = 'F';
    }
        return grades;
}

   public static int getMax(int[] array) {
       int big = array[0];
       for (int o = 1; o < array.length; o++) {
           if (array[o] > big)
               big = array[o];
       }
       return big;
           }

    public static int average(int[] array) {
        double sum = 0;
        for (int i = 0 ; i<array.length ; i++){
            sum += array[i];
        }
        return (int)sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0;
        for (int i = 0 ; i<array.length ; i++){
            sum += array[i];
        }
        return sum / array.length;
    }

    public static int random(int start, int end, int... exclude) {
        int ran = random(start,end);
        for (int i = 0; i < exclude.length; i++) {
            while (ran == exclude[i]){
                ran = random(start, end,exclude);
            }
       }
        return ran;
    }

   public static int[] eliminateDuplicates(int[] array) {
      int n = 10;
       int[] temporary = new int[n];
       int j = 0;
       for (int i = 0; i < n - 1; i++)
           if (array[i] != array[i + 1])
               temporary[j++] = array[i];
       temporary[j++] = array[n - 1];
       for (int i = 0; i < j; i++)
           array[i] = temporary[i];
       return temporary;
   }

      public static void shuffle(int[] array) {
          for (int i = array.length - 1; i > 0; i--) {
              double j = Math.floor(Math.random() * (i + 1));
              int temp = array[i];
              array[i] = array[(int)j];
              array[(int)j] = temp;
          }
      }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp = 0;
                if (array[i]>array[j]) {
                    swap(array, i, j);
                }
                }
            }
return true;
    }

    public static int[] lockers(boolean[] locker) {
        int[] lockergo = new int[100];
        return lockergo;
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(double[] array) {
        for (double i : array) {
            System.out.printf("%.1f\t", i);
        }
        System.out.println();
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double random(double start, double end) {
        return start + Math.random() * (end - start + 1);
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}