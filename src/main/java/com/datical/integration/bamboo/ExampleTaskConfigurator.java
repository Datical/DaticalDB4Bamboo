package com.datical.integration.bamboo;

import com.atlassian.bamboo.collections.ActionParametersMap;
import com.atlassian.bamboo.task.AbstractTaskConfigurator;
import com.atlassian.bamboo.task.TaskDefinition;
import com.atlassian.bamboo.utils.error.ErrorCollection;
import com.opensymphony.xwork.TextProvider;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ExampleTaskConfigurator extends AbstractTaskConfigurator
{
    private TextProvider textProvider;

    @NotNull
    @Override
    public Map<String, String> generateTaskConfigMap(@NotNull final ActionParametersMap params, @Nullable final TaskDefinition previousTaskDefinition)
    {
        final Map<String, String> config = super.generateTaskConfigMap(params, previousTaskDefinition);

        config.put("hammer", params.getString("hammer"));
        config.put("drivers", params.getString("drivers"));
        config.put("projectDir", params.getString("projectDir"));
        

        return config;
    }

    @Override
    public void populateContextForCreate(@NotNull final Map<String, Object> context)
    {
        super.populateContextForCreate(context);

        context.put("hammer", "ex: C:\\Program Files (x86)\\DaticalDB\\repl\\hammer.bat");
        context.put("drivers", "ex: C:\\MyDrivers");
        context.put("projectDir", "ex: C:\\Users\\<username>\\datical\\MyProject");
        
        
    }

    @Override
    public void populateContextForEdit(@NotNull final Map<String, Object> context, @NotNull final TaskDefinition taskDefinition)
    {
        super.populateContextForEdit(context, taskDefinition);

        context.put("hammer", taskDefinition.getConfiguration().get("hammer"));
        context.put("drivers", taskDefinition.getConfiguration().get("drivers"));
        context.put("projectDir", taskDefinition.getConfiguration().get("projectDir"));
        
    }

    @Override
    public void populateContextForView(@NotNull final Map<String, Object> context, @NotNull final TaskDefinition taskDefinition)
    {
        super.populateContextForView(context, taskDefinition);
        context.put("hammer", taskDefinition.getConfiguration().get("hammer"));
        context.put("drivers", taskDefinition.getConfiguration().get("drivers"));
        context.put("projectDir", taskDefinition.getConfiguration().get("projectDir"));
        
    }

    @Override
    public void validate(@NotNull final ActionParametersMap params, @NotNull final ErrorCollection errorCollection)
    {
        super.validate(params, errorCollection);

        final String hammerValue = params.getString("hammer");
        if (StringUtils.isEmpty(hammerValue))
        {
            errorCollection.addError("hammer", textProvider.getText("daticaldb.hammer.error"));
        }

        final String driversValue = params.getString("drivers");
        if (StringUtils.isEmpty(driversValue))
        {
            errorCollection.addError("drivers", textProvider.getText("daticaldb.drivers.error"));
        }

        final String projectDirValue = params.getString("projectDir");
        if (StringUtils.isEmpty(projectDirValue))
        {
            errorCollection.addError("projectDir", textProvider.getText("daticaldb.projectDir.error"));
        }
    }

    public void setTextProvider(final TextProvider textProvider)
    {
        this.textProvider = textProvider;
    }
}
