package com.pineone.icbms.so.virtualobject.composite;

import com.pineone.icbms.so.virtualobject.AGenericVirtualObject;
import com.pineone.icbms.so.virtualobject.IGenericVirtualObject;
import com.pineone.icbms.so.virtualobject.aspect.IGenericAspect;
import com.pineone.icbms.so.virtualobject.functionlity.IGenericFunctionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Composite Virtual Object abstract generic class.<BR/>
 *
 * Created by uni4love on 2016. 11. 17..
 */
abstract public class AGenericCompositeVirtualObject extends AGenericVirtualObject implements IGenericCompositeVirtualObject {
    /**
     * virtual object list
     */
    protected List<IGenericVirtualObject> virtualObjectList = new ArrayList<>();

    /**
     * current depth
     */
    private int currentDepth = 0;

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericCompositeVirtualObject(String id, String name) {
        super(id, name);
    }

    @Override
    public List<IGenericVirtualObject> getVirtualObjectList() {
        return virtualObjectList;
    }

    public void setVirtualObjectList(List<IGenericVirtualObject> virtualObjectList) {
        this.virtualObjectList = virtualObjectList;
    }

    /**
     * add a Virtual Object.<BR/>
     *
     * @param virtualObject virtual object
     */
    @Override
    public void addVirtualObject(IGenericVirtualObject virtualObject) {
        //CVO에 하위 CVO를 추가할 경우
        if(virtualObject instanceof IGenericCompositeVirtualObject)
        {
            //increase to current+1
            ((IGenericCompositeVirtualObject) virtualObject).setCurrentDepth(getCurrentDepth()+1);
        }
        this.virtualObjectList.add(virtualObject);
    }

    /**
     * return current hop count.<BR/>
     *
     * @return hop count
     */
    @Override
    public int getCurrentDepth() {
        return currentDepth;
    }

    /**
     * set current depth.<BR/>
     *
     * @param depth depth
     */
    @Override
    public void setCurrentDepth(int depth) {
        this.currentDepth = depth;
    }

    /**
     * return functionality list.<BR/>
     *
     * @return functionality list
     */
    public List<IGenericFunctionality> getFunctionalityList() {
        //implements...
        return null;
    }

    /**
     * return aspect list.<BR/>
     *
     * @return aspect list
     */
    public List<IGenericAspect> getAspectList() {
        //implements...
        return null;
    }

    /**
     * return aspect-functionality list.<BR/>
     *
     * @return aspect-functionality list
     */
    public Map<IGenericAspect, IGenericFunctionality> getAspectFunctionalityList() {
        //implements...
        return null;
    }



    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(super.toString());
        //vo list
        sb.append(", \nvirtual object list = ").append(virtualObjectList);
        return sb.toString();
    }
}
