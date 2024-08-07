package c5;

class ex_5 {
    public static void main(String[] args) {
        ex_5 out = new ex_5();
        out.go();

    }

    void go() {
        int value = 7;
        for (int i = 1; i < 8; i++) {
            value++;
            if (i > 4) {
                System.out.print(++value + " ");
            }
            if (value > 14) {
                System.out.println(" i=" + i);
                break;
            }
        }
    }
}

//  output :  13 15  i=6