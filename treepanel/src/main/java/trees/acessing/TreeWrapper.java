package trees.acessing;

import trees.layout.Child;
import trees.layout.Node;
import trees.layout.PlaceHolder;
import trees.layout.Root;
import trees.panel.style.Style;

public class TreeWrapper {
	
	public Root wrap(Object object, Style style){
		if(object == null)
			return null;
		
		WrappedNode wrappedRoot = new WrappedNode(object);		
		Root root = new Root(wrappedRoot);
		
		wrap(root, wrappedRoot, style);
		
		return root;
	}

	private void wrap(Node node, WrappedNode wrappedNode, Style style){
		Class<?> descendantClass = wrappedNode.getFirstDescendant();
		boolean usePlaceHolders = (descendantClass != null && style.usesPlaceHolder(descendantClass));
		for(Object object : wrappedNode.getDescendants())
			if(object == null)
				if(usePlaceHolders)
					node.add(new PlaceHolder(descendantClass));
				else
					node.add((Node)null);
			else{
				WrappedNode wrappedChild = new WrappedNode(object);
				Node child = new Child(wrappedChild);
				node.add(child);
				wrap(child, wrappedChild, style);
			}		
	}

}
