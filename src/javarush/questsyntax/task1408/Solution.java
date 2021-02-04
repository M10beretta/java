package javarush.questsyntax.task1408;

public class Solution {
    public static void main(String[] args) {
        HenFactory.getHen(Country.RUSSIA);
        HenFactory.getHen(Country.UKRAINE);
        HenFactory.getHen(Country.MOLDOVA);
        HenFactory.getHen(Country.BELARUS);

    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
/*            if (country.equals(Country.RUSSIA)) {
                hen = new RussianHen();
                System.out.println(hen.getDescription());
            }
            if (country.equals(Country.UKRAINE)) {
                hen = new UkrainianHen();
                System.out.println(hen.getDescription());
            }
            if (country.equals(Country.MOLDOVA)) {
                hen = new MoldovanHen();
                System.out.println(hen.getDescription());
            }
            if (country.equals(Country.BELARUS)) {
                hen = new BelarusianHen();
                System.out.println(hen.getDescription());
            }*/

            switch (country) {
                case Country.RUSSIA:
                    hen = new RussianHen();
                    System.out.println(hen.getDescription());
                    break;
                case Country.UKRAINE:
                    hen = new UkrainianHen();
                    System.out.println(hen.getDescription());
                    break;
                case Country.MOLDOVA:
                    hen = new MoldovanHen();
                    System.out.println(hen.getDescription());
                    break;
                case Country.BELARUS:
                    hen = new BelarusianHen();
                    System.out.println(hen.getDescription());
                    break;
            }
            return hen;
        }
    }
}

