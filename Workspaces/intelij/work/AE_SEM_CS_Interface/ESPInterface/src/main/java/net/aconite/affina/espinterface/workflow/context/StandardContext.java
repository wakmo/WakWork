package net.aconite.affina.espinterface.workflow.context;


import java.util.HashMap;
import java.util.Map;
import net.aconite.affina.espinterface.workflow.service.IContext;

/**
 * User: wakkir
 * Date: 07/03/14
 * Time: 23:15
 */
public class StandardContext implements IContext
{

    private Map<String, Object> context;

    /**
     * Create context object based.
     *
     * @param parameters
     */
    public StandardContext(Map<String, Object> parameters)
    {
        if (parameters == null)
        {
            this.context = new HashMap<String, Object>();
        }
        else
        {
            this.context = parameters;
        }
    }

    @Override
    public Object getAttribute(String name)
    {
        return context.get(name);
    }

    @Override
    public void setAttribute(String name, Object value)
    {
        context.put(name, value);
    }

}