package org.example;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.ManagementLink;
import hudson.model.Describable;
import jenkins.model.Jenkins;

@Extension
public class DemoPlugin extends ManagementLink implements Describable<DemoPlugin> {
    @Override
    public String getIconFileName() {
        return "gear.png";
    }

    @Override
    public String getDisplayName() {
        return "Demo Plugin";
    }

    @Override
    public String getUrlName() {
        return "demo-plugin";
    }

    @Override
    public Descriptor<DemoPlugin> getDescriptor() {
        return Jenkins.get().getDescriptorOrDie(this.getClass());
    }
}
