package org.ovirt.mobile.movirt.model.condition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.ovirt.mobile.movirt.R;
import org.ovirt.mobile.movirt.model.Vm;

public class MemoryThresholdCondition extends Condition<Vm> {
    public final int percentageLimit;

    @JsonCreator
    public MemoryThresholdCondition(@JsonProperty("percentageLimit") int percentageLimit) {
        this.percentageLimit = percentageLimit;
    }

    @Override
    public boolean evaluate(Vm entity) {
        return entity.getMemoryUsage() >= percentageLimit;
    }

    @Override
    public String getMessage(Vm vm) {
        return getResources().getString(R.string.vm_memory_message, vm.getName(), percentageLimit, vm.getMemoryUsage());
    }

    @Override
    public String toString() {
        return "Memory usage over " + percentageLimit + "%";
    }
}
