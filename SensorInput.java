class Playground {
    public static void main(String[ ] args) {
        String hex1 = "FFFF00";
        String hex2 = "FFFFFF";
        String hex31 = "FFFFFF";

        int decimal1 = Integer.parseInt(hex1,16);
        int decimal2 = Integer.parseInt(hex2,16);
        int decimal3 = Integer.parseInt(hex31,16);

        System.out.println(decimal1);
        System.out.println(decimal2);
        System.out.println(decimal3);

        int dif1 = decimal1-decimal3;
        int dif2 = decimal2-decimal3;

        System.out.println(dif1);
        System.out.println(dif2);

        if (Math.abs(dif1) > Math.abs(dif2)) {
            System.out.println("White, moving on.");
            String hex32 = "FFFFFF";

            int decimal4 = Integer.parseInt(hex1,16);
            int decimal5 = Integer.parseInt(hex2,16);
            int decimal6 = Integer.parseInt(hex32,16);

            int dif3 = decimal4-decimal6;
            int dif4 = decimal5-decimal6;

            System.out.println(dif3);
            System.out.println(dif4);

            if (Math.abs(dif3) > Math.abs(dif4)) {
                System.out.println("White, moving on.");
                String hex33 = "FFFF00";

                int decimal7 = Integer.parseInt(hex1,16);
                int decimal8 = Integer.parseInt(hex2,16);
                int decimal9 = Integer.parseInt(hex33,16);

                int dif5 = decimal7-decimal9;
                int dif6 = decimal8-decimal9;

                System.out.println(dif5);
                System.out.println(dif6);
                if (Math.abs(dif5) > Math.abs(dif6)) {
                    System.out.println("White, ERROR");

                }else if (Math.abs(dif5) < Math.abs(dif6)) {
                    System.out.println("Gold, found in position 3");
                }
            }
            else if (Math.abs(dif3) < Math.abs(dif4)) {
                System.out.println("Gold, found target in position 2");
            }
        }
        else if (Math.abs(dif1) < Math.abs(dif2)) {
            System.out.println("Gold, found target in position 1");
        }
    }
}