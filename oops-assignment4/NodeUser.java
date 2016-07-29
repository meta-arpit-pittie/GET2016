/**
 * Assignment 1
 * Class to represent the User type of nodes in the graph
 * @author Arpit Pittie
 */
package session5;

import java.util.ArrayList;
import java.util.List;

public class NodeUser extends Node{
	
	private ProfileUser profile;	//The attributes for the organisation node
	private List<Node> neighbour; 		//The list of all the immediate neighbours of the node
	private List<Node> blocked;		//The list of nodes with whom the edge creation is blocked
	
	public NodeUser(String name, String place, String type) {
		profile = new ProfileUser(name, place, type);
		neighbour = new ArrayList<Node>();
		blocked = new ArrayList<Node>();
	}
	
	@Override
	public String getName() {
		return profile.getName();
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		profile.setName(name);
	}
	
	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return profile.getPlace();
	}
	
	@Override
	public void setPlace(String place) {
		// TODO Auto-generated method stub
		profile.setPlace(place);
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return profile.getType();
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		profile.setType(type);
	}

	@Override
	public void addNeighbour(Node conn) {
		// TODO Auto-generated method stub
		if(!neighbour.contains(conn)) {
			neighbour.add(conn);
		}
	}
	
	@Override
	public boolean removeNeighbour(Node remove) {
		// TODO Auto-generated method stub
		if(neighbour.contains(remove)) {
			neighbour.remove(remove);
			return true;
		}
		return false;
	}

	@Override
	public void displayNeighbour() {
		// TODO Auto-generated method stub
		for(int i=0; i < neighbour.size(); i++) {
			System.out.print(neighbour.get(i).getName()+" ");
		}
		
		if(neighbour.size() < 4){
			System.out.print("\t");
		}
	}

	@Override
	public boolean removeProfile() {
		// TODO Auto-generated method stub
		profile = null;
		return true;
	}

	@Override
	public boolean isFriend(Node query) {
		// TODO Auto-generated method stub
		if(neighbour.contains(query)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Node> getNeighbours() {
		// TODO Auto-generated method stub
		return neighbour;
	}
	
	@Override
	public boolean blockNode(Node node) {
		// TODO Auto-generated method stub
		if(!blocked.contains(node)) {
			blocked.add(node);
			return true;
		}
		return false;
	}

	@Override
	public boolean isBlockedNode(Node node) {
		// TODO Auto-generated method stub
		if(blocked.contains(node)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Compares this node with the specified object. The result is true if and only if
	 * the object is not null and is of Node type that has the same attribute values
	 * @param obj - The object to compare this Node against 
	 * @return true if the given object represents a Node equivalent to this node, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		try {
			Node n = (Node) obj;
			if(hashCode() == n.hashCode()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Returns a hash code for this node. The hash code is computed as 
	 * attrib[0].hasCode()+attrib[1].hashCode()+...+attrib[n-1].hashCode()
	 * where attrib are the attributes associated with the node
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		return getName().hashCode() + getPlace().hashCode() + getType().hashCode();
	}
	
}
