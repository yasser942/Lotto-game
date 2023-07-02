public class Homework3 {
    public static int randomNumber(int maxRand) {
        int random = (int) (1 + Math.random() * maxRand);
        return random;
    }
    public static void show(Queue q){
        int sizeq=q.size();
        for (int i = 0; i < sizeq; i++) {
            System.out.print(q.peek() + " ");
            q.enqueue(q.dequeue());
        }

    }
    public static int delete(Queue bag1, Queue bag2){
        int q_size = bag1.size();
        int selected =0;
        int a = randomNumber(q_size);

        for (int i = 1; i <= q_size; i++) {
            if (a==i){
                selected=(int)bag1.peek();
            }
            bag1.enqueue(bag1.dequeue());
        }

        for (int i =0;i<q_size;i++){
            Object element = bag1.peek();
            if (selected==(int) element){
                bag2.enqueue(element);
                bag1.dequeue();
            }
            else {
                bag1.enqueue(bag1.dequeue());
            }
        }
        return selected;
    }// chosing a random number from Bag1 and delete it after adding Bag2
    public static void randomization(Queue q1 ,Queue q2 ){
        int counter=0;
        int q1_size= q1.size();
        int a = randomNumber(q1_size);
        while (counter<7){
            for (int i = 1; i <= a; i++) {
                if (i==a) {
                    q2.enqueue(q1.dequeue());
                    counter++;
                }
                q1.enqueue(q1.dequeue());

            }

        }
    }/// randomizing element in queues
    public static void main(String[] args) {

        Queue Bag2 = new Queue(1000);//bag1
        Queue Bag1 = new Queue(1000);//bag2
        Queue q1 = new Queue(1000);//queue only for randomization
        Queue player1 = new Queue(1000);//queue only for randomization
        Queue q2 = new Queue(1000);//queue only for randomization
        Queue player2 = new Queue(1000);//queue only for randomization



        int counter1 = 0;
        int score1 = 0;
        int counter2 = 0;
        int score2 = 0;
        int selected = 0;
        int numberOfTries1 = 0;
        int numberOfTries2 = 0;
        boolean flag = true;
//------------------------- filling queues and randomizing their elements ---------------------

        for (int i = 1; i <= 17; i++) {
            q1.enqueue(i);
            q2.enqueue(i);
            Bag1.enqueue(i);
        }
        randomization(q1,player1);
        randomization(q2,player2);
        //--------------------------------- starting game ----------------------------------------------
        System.out.print("Player1: ");
        show(player1);
        System.out.println();
        System.out.printf("%50s", "Bag1 : ");
        show(Bag1);
        System.out.println();
        System.out.print("Player2: ");
        show(player2);
        System.out.println();
        System.out.printf("%50s", "Bag2 : ");
        show(Bag2);
        System.out.println("\n-----------------------------------------------------------------------------");

//--------------------------------- the main while loop -----------------------------------------
        while (!player1.isEmpty() && !player2.isEmpty()) {

            selected=delete(Bag1,Bag2);
            System.out.print("Selected number: "+selected);
            System.out.println();
            //removing an element
            int player1_size= player1.size();
            for (int i = 0; i < player1_size; i++) {
                Object element = player1.peek();
                if ((selected == (int) element)) {
                    player1.dequeue();
                    counter1++;
                    numberOfTries1++;
                } else {
                    player1.enqueue(player1.dequeue());
                }
            }
            int player2_size= player2.size();
            for (int i = 0; i < player2_size; i++) {
                Object element = player2.peek();
                if ((selected == (int) element)) {

                    player2.dequeue();
                    counter2++;
                    numberOfTries2++;
                } else {
                    player2.enqueue(player2.dequeue());
                }

            }
            if (flag) {

                if (counter1 == counter2 && counter1 == 4) {
                    System.out.println("Player1 gets $10 (Birinci Çinko)");
                    System.out.println("Player2 gets $10 (Birinci Çinko)");
                    score1 += 10;
                    score2 += 10;
                    flag=false;
                } else if (counter1 == 4 && counter2 < 4) {
                    System.out.println("Player1 gets $10 (Birinci Çinko)");
                    score1 += 10;
                    flag=false;

                } else if (counter2 == 4 && counter1 < 4) {
                    System.out.println("Player2 gets $10 (Birinci Çinko)");
                    score2 = 10;
                    flag=false;
                }
            }

            System.out.print("Player1: ");
            show(player1);
            System.out.println();
            System.out.printf("%50s", "Bag1 : ");
            show(Bag1);
            System.out.println();
            System.out.print("Player2: ");
            show(player2);
            System.out.println();
            System.out.printf("%50s", "Bag2 : ");
            show(Bag2);



            System.out.println("\n");
            System.out.println("-----------------------------------------------------------------------------");
        }


//----------------------------- scoring -------------------------------------------------------------
        if (numberOfTries1 > numberOfTries2) {
            score1 += 30;
            System.out.println("Player1 is the winner !!!");
            System.out.println("Player1 gets  $" + score1);
            System.out.println("Player2 gets $" + score2);
        } else if (numberOfTries1 < numberOfTries2) {
            score2 += 30;
            System.out.println("Player2 is the winner !!!");
            System.out.println("Player1 gets  $" + score1);
            System.out.println("Player2 gets $" + score2);
        } else {
            System.out.println("Tie !!");
            double sumOfScores=(double) (score1+score2)/2;
            System.out.println("Both of players get $"+sumOfScores);
            System.out.println("Player1 gets  $" + sumOfScores);
            System.out.println("Player2 gets $" + sumOfScores);
        }


    }

}





