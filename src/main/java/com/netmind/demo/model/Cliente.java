package com.netmind.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@NotNull(message = "The id should not be null")
	@Positive(message = "The id should be greater than 0")
	private Integer IdCliente;

	@Column(name = "nombre")
	@NotNull(message = "This field is mandatory")
	@NotBlank(message = "This field cant be blank")
	private String nombre;

	@Column(name = "apellidos")
	@NotNull(message = "This field is mandatory")
	@NotBlank(message = "This field cant be blank")
	private String apellidos;

	@Column(name = "dni")
	@NotNull(message = "This field is mandatory")
	@NotBlank(message = "This field cant be blank")
	private Integer dni;

	// bi-directional many-to-one association to Pedidos
	@OneToMany(mappedBy = "cliente")
	private List<Pedidos> pedidos;

	public void loadLazyPedidos() {
		EntityManagerFactory factoria = Persistence
				.createEntityManagerFactory("Cliente");
		EntityManager em = factoria.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pedidos> cq = cb.createQuery(Pedidos.class);

		Root<Pedidos> model = cq.from(Pedidos.class);
		cq.where(cb.equal(model.get("cliente"), this));
		TypedQuery<Pedidos> tq = em.createQuery(cq);

		this.pedidos = new ArrayList<Pedidos>();
		for (Pedidos v : tq.getResultList()) {
			this.pedidos.add(v);
		}
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedidos addPedidos(Pedidos pedidos) {
		getPedidos().add(pedidos);
		pedidos.setCliente(this);

		return pedidos;
	}

	public Pedidos removePedidos(Pedidos pedidos) {
		getPedidos().remove(pedidos);
		pedidos.setCliente(null);

		return pedidos;
	}

}
