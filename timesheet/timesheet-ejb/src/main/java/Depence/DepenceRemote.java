package Depence;

import javax.ejb.Remote;

@Remote
public interface DepenceRemote {
	public String getDepence();
	public String Add(String s );


}
