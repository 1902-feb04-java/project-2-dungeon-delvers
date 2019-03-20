package DD.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="campaigns")
public class Campaign {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String save_state;
	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Campaign(long id, String name, String save_state) {
		super();
		this.id = id;
		this.name = name;
		this.save_state = save_state;
	}
	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", save_state=" + save_state + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSave_state() {
		return save_state;
	}
	public void setSave_state(String save_state) {
		this.save_state = save_state;
	}
	
	
}
