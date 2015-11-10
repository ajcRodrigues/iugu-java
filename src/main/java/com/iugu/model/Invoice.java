package com.iugu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

public class Invoice implements Serializable
{

	private static final long serialVersionUID = 1719931730355279382L;

	/**
	 * E-Mail do cliente
	 */
   private String email;
   
   /**
    * Data de Expiração (DD/MM/AAAA)
    */
   @JsonProperty("due_date")
   @JsonFormat("dd/MM/yyyy") @JsonSerialize(using = DateSerializer.class)
   private Date dueDate;
   
   /**
    * Itens da Fatura
    */
   private List<Item> items = new ArrayList<>();
   
   /**
    * Cliente é redirecionado para essa URL após efetuar o pagamento da Fatura pela página de Fatura da Iugu
    */
   @JsonProperty("return_url")
   private String returnUrl;
   
   /**
    * Cliente é redirecionado para essa URL se a Fatura que estiver acessando estiver expirada
    */
   @JsonProperty("expired_url")
   private String expiredUrl;

   /**
    * URL chamada para todas as notificações de Fatura, assim como os webhooks (Gatilhos) são chamados
    */
   @JsonProperty("notification_url")
   private String notificationUrl;
   
   /**
    * Valor dos Impostos em centavos
    */
   @JsonProperty("tax_cents")
   private Integer taxCents;
   
	/**
	 * Booleano para Habilitar ou Desabilitar multa por atraso de pagamento
	 */
   private Boolean fines;
   
   /**
    * Determine a multa a ser cobrada para pagamentos efetuados após a data de vencimento
    */
   @JsonProperty("late_payment_fine")
   private Double latePaymentFine;
   
   /**
    * Booleano que determina se cobra ou não juros por dia de atraso. 1% ao mês pro rata.
    */
   @JsonProperty("per_day_interest")
   private Double perDayInterest;
   
   /**
    * Valor dos Descontos em centavos
    */
   @JsonProperty("discount_cents")
   private Integer discountCents;
   
   public Invoice(String email, Date dueDate, Item... items) {
	   this.email = email;
	   this.dueDate = dueDate;
	   this.items.addAll(Arrays.asList(items)); //FIXME Tratar null pointer
   }

	public String getEmail() {
		return email;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public String getReturnUrl() {
		return returnUrl;
	}
	
	public Invoice withReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}
	
	public String getExpiredUrl() {
		return expiredUrl;
	}
	
	public Invoice withExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
		return this;
	}
	
	public String getNotificationUrl() {
		return notificationUrl;
	}
	
	public Invoice withNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
		return this;
	}
	
	public Integer getTaxCents() {
		return taxCents;
	}
	
	public Invoice withTaxCents(Integer taxCents) {
		this.taxCents = taxCents;
		return this;
	}
	
	public Boolean getFines() {
		return fines;
	}
	
	public Invoice withFines(Boolean fines) {
		this.fines = fines;
		return this;
	}
	
	public Double getLatePaymentFine() {
		return latePaymentFine;
	}
	
	public void setLatePaymentFine(Double latePaymentFine) {
		this.latePaymentFine = latePaymentFine;
	}
	
	public Double getPerDayInterest() {
		return perDayInterest;
	}
	
	public void setPerDayInterest(Double perDayInterest) {
		this.perDayInterest = perDayInterest;
	}
	
	public Integer getDiscountCents() {
		return discountCents;
	}
	
	public void setDiscountCents(Integer discountCents) {
		this.discountCents = discountCents;
	}
   
}