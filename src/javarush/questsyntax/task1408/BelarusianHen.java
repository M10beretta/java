package javarush.questsyntax.task1408;

public class BelarusianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 130;
    }

    @Override
    public String getDescription() {
        return  String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(), Country.BELARUS, getCountOfEggsPerMonth());
    }
}
