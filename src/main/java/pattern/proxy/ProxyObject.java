package pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyObject implements RealInterface {

    private RealInterface realInterface;

    @Override
    public void helloWorld() {
        realInterface = new RealObject();

        log.info("before call helloWorld");
        realInterface.helloWorld();
        log.info("after call helloWorld");
    }
}
