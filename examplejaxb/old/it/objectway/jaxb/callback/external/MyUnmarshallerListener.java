package it.objectway.jaxb.callback.external;


import javax.xml.bind.Unmarshaller;

public class MyUnmarshallerListener extends Unmarshaller.Listener{

	@Override
	public void afterUnmarshal(Object target, Object parent) {
		String parentString = " , parent = ";
    	if(parent!=null){
    		parentString = parentString + parent.getClass().getName();
    	}
    	System.out.println("afterUnmarshal:  target " +target.getClass().getName() + parentString);
	}

	@Override
	public void beforeUnmarshal(Object target, Object parent) {
		String parentString = " parent = ";
    	if(parent!=null){
    		parentString = parentString + parent.getClass().getName();
    	}
    	System.out.println("beforeUnmarshal:  target " +target.getClass().getName() + parentString);
	}
}
