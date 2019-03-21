package DD.entity;

import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.Property;

@Entity
@Table(name="monsters")
public class Monster {
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dd")
	private int damageDie;
	
	@Column(name="ac")
	private int ac;
	
	@Column(name="hp")
	private int hp;
	@Column(name="account_id")
	private int accountId;
	@Override
	public String toString() {
		return "Monster [id=" + id + ", name=" + name + ", damageDie=" + damageDie + ", ac=" + ac + ", hp=" + hp
				+ ", account_id=" + accountId + "]";
	}
	public Monster(long id, String name, int damageDie, int ac, int hp, int account_id) {
		super();
		this.id = id;
		this.name = name;
		this.damageDie = damageDie;
		this.ac = ac;
		this.hp = hp;
		this.accountId = account_id;
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
	public int getDamageDie() {
		return damageDie;
	}
	public void setDamageDie(int damageDie) {
		this.damageDie = damageDie;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAccount_id() {
		return accountId;
	}
	public void setAccount_id(int account_id) {
		this.accountId = account_id;
	}
	
	
}
