package pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealObject implements RealInterface {
    @Override
    public void helloWorld() {
        log.info("Hello World...");
    }
}
