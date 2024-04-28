package visibility;

public class Fisherman {

    volatile boolean takeBait = false;

    public void fishing() {
        var fishing = new Thread(() -> {
            long count = 0;
            while (!takeBait) {
                count++;
            }
            System.out.println("낚시 성공! " + count);
        });

        var feeding = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            takeBait = true;
            System.out.println("물고기가 미끼를 물었습니다!");
        });

        fishing.start();
        feeding.start();
    }
}
