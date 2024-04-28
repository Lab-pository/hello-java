package visibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fisherman {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    volatile boolean takeBait = false; // 만약 volatile 키워드가 없다면?

    public void fishing() {
        var fishing = new Thread(() -> {
            long count = 0;
            while (!takeBait) {
                count++;
            }
            log.info("낚시 성공! {}", count);
        });

        var feeding = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            takeBait = true;
            log.info("물고기가 미끼를 물었습니다!");
        });

        fishing.start();
        feeding.start();
    }
}
