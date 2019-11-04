package knight;

public class KnightlyDuel {

    public static void main(String[] args) {
        System.out.println("You must shoot at step " + bestStep(0.1, 0.1, 2));

    }

    public static int bestStep(double p1, double p2, int n) {

        int result = 0;
        double steps = 10;
        double distance = steps * 2;
        double startProb1 = p1;
        double startProb2 = p2;

        double[] chance1 = new double[(int) steps];
        double[] chance2 = new double[(int) steps];

        for (int i = 0; i < steps; i++) chance1[i] = (p1 += ((1 - startProb1) / (distance - steps)));
        for (int i = 0; i < steps; i++) chance2[i] = p2 += ((1 - startProb2) / ((distance - 1) - steps));

        if (n == 1) {
            for (int i = 0; i < steps; i++) {
                result = i;
                if ((chance1[i] > 0.66 || chance2[i + 1] > 0.66)) {
                    break;
                }

            }
        } else if (n == 2) {
            for (int i = 0; i < steps; i++) {
                result = i;
                if ((chance2[i] > 0.66 || chance1[i + 1] > 0.66)) {
                    break;
                }
            }
        } else throw new Error();

        return result;
    }
}

/*
будем иметь ввиду что мы под номером 1
задаем количество шагов
присваеваем начальные веротяности из заданных параметров
если вероятность растет линейно , на 10ом шаге она равняется 1 и задается начальное значение вероятности -
считаем коефициент прибавления вероятности на каждом шаге
заполним в массив значения  в массивы

Наиболее оптимальный шаг для произведения выстрела  будем считать тот, когда наш коеф больше 0,66 или шаг перед шагом соперника, когда при следующем выстреле соперника его коеф будет больше 0,66
 */


