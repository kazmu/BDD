package com.jbehave.testproject;

import com.jbehave.testproject.Configuration.DefaultConfiguration;
import com.jbehave.testproject.Steps.MainPageStorySteps;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;


@RunWith(JUnitReportingRunner.class)
public class jBehaveTestRun extends JUnitStories {

    @Override
    public Configuration configuration(){
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        return defaultConfiguration.getConfiguration();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(
                configuration(), new MainPageStorySteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(
                this.getClass()),
                Arrays.asList("**/*.story"),
                Arrays.asList(""));
    }
}

