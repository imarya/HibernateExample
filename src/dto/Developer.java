package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "developer")
public class Developer {

	/*
	 * if @GeneratedValue() not specified it's assigned, user will provide id.
	 * It generates the unique id only if no other process is inserting data
	 * into this table. It generates short, int or long type identifier. The
	 * first generated identifier is 1 normally and incremented as 1.
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	/*
	 * It uses the sequence of the database. if there is no sequence defined, it
	 * creates a sequence automatically e.g. in case of Oracle database, it
	 * creates a sequence named HIBERNATE_SEQUENCE. In case of Oracle, DB2, SAP
	 * DB, Postgre SQL or McKoi, it uses sequence but it uses generator in
	 * interbase.
	 */
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	/*
	 * It is used in Sybase, My SQL, MS SQL Server, DB2 and HypersonicSQL to
	 * support the id column. The returned id is of type short, int or long.
	 */
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * @GenericGenerator(name = "table", strategy = "enhanced-table", parameters
	 * = { @org.hibernate.annotations.Parameter(name = "table_name", value =
	 * "sequence_table") })
	 * 
	 * @GeneratedValue(generator = "table", strategy = GenerationType.TABLE)
	 */
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "fname")
	private String firstName;

	@Column(name = "lname")
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", unique = true)
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmailIdentity> emailId;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Technology> technology;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Company company;

	// Getters Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Technology> getTechnology() {
		return technology;
	}

	public void setTechnology(List<Technology> technology) {
		this.technology = technology;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<EmailIdentity> getEmailId() {
		return emailId;
	}

	public void setEmailId(List<EmailIdentity> emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
