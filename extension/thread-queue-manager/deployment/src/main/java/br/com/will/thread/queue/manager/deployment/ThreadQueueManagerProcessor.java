package br.com.will.thread.queue.manager.deployment;

import br.com.will.thread.queue.manager.runtime.service.impl.PlatformThreadQueueManager;
import br.com.will.thread.queue.manager.runtime.service.impl.VirtualThreadQueueManager;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class ThreadQueueManagerProcessor {

    private static final String FEATURE = "thread-queue-manager";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    public void createThreadQueueManagerBeans(BuildProducer<AdditionalBeanBuildItem> additionalBeans) {

        additionalBeans
                .produce(AdditionalBeanBuildItem.builder().addBeanClass(PlatformThreadQueueManager.class).build());

        additionalBeans
                .produce(AdditionalBeanBuildItem.builder().addBeanClass(VirtualThreadQueueManager.class).build());

    }
}
