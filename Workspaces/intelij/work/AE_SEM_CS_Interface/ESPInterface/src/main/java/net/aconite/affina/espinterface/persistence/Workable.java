/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.persistence;

/**
 * A class that defines the work which can be carried out by a database worker,
 * takes an  argument, and holds a response.
 * The work is carried out in a (non-container) transactional context.
 * @author thushara.pethiyagoda
 */
abstract public class Workable<T, R>
{
    /** Any data that can used by the workable to do its work.*/
    private T data;
    /** A response data generated as part of the work carried out here. */
    private R response;

    /**
     * Constructs a default Workable
     */
    protected Workable()
    {
        
    }
    /**
     * 
     * @param dataHolder
     * @param responseData 
     */
    protected Workable(T dataHolder)
    {
        data = dataHolder;        
    }
    /**
     * Returns the data to be used by Workable
     * @return 
     */
    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    /**
     * Returns a Response generated by Workable.
     * @return 
     */
    public R getResult()
    {
        return response;
    }

    public void setResponse(R response)
    {
        this.response = response;
    }

    /**
     * Implement this method to execute activities 
     * that can be done within a database transaction.
     */
    abstract public void doWork();

}