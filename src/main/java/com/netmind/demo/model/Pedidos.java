package com.netmind.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "pedidos")
public class Pedidos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@NotNull(message = "The id should not be null")
	@Positive(message = "The id should be greater than 0")
	private Integer idPedidos;

	@Column(name = "fechaHoraEntrega")
	@NotNull(message = "This field is mandatory")
	@NotBlank(message = "This field cant be blank")
	@Temporal(TemporalType.DATE)
	private Date fechaHoraEntrega;

	@Column(name = "precio")
	@NotNull(message = "This field is mandatory")
	@NotBlank(message = "This field cant be blank")
	private BigDecimal precio;

	@Column(name = "detallesPedido")
	@NotBlank(message = "This field cant be blank")
	private String detallesPedido;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

}
