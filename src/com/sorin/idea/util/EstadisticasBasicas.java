package com.sorin.idea.util;

public class EstadisticasBasicas {

	private String tipo;
	private long numero;
	private double porcentaje;
	private long numero2;
	private double porcentaje2;
	private long numero3;
	private double porcentaje3;
	private long numero4;
	private double porcentaje4;
	private long numero5;
	private double porcentaje5;
	private long numero6;
	private double porcentaje6;
	private long numero7;
	private double porcentaje7;
	private long numero8;
	private double porcentaje8;
	private long numero9;
	private double porcentaje9;
	
	private long suma1;
	private long suma2;
	private long suma3;
	
	public EstadisticasBasicas(){
	}
	public EstadisticasBasicas(String t,long n,double p){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3,long n4,double p4){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
		this.setNumero4(n4);
		this.setPorcentaje4(p4);	
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3,long n4,double p4,long n5,double p5){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
		this.setNumero4(n4);
		this.setPorcentaje4(p4);
		this.setNumero5(n5);
		this.setPorcentaje5(p5);
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3,long n4,double p4,long n5,double p5,long n6,double p6){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
		this.setNumero4(n4);
		this.setPorcentaje4(p4);
		this.setNumero5(n5);
		this.setPorcentaje5(p5);
		this.setNumero6(n6);
		this.setPorcentaje6(p6);
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3,long n4,double p4,long n5,double p5,long n6,double p6,long n7,double p7){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
		this.setNumero4(n4);
		this.setPorcentaje4(p4);
		this.setNumero5(n5);
		this.setPorcentaje5(p5);
		this.setNumero6(n6);
		this.setPorcentaje6(p6);
		this.setNumero7(n7);
		this.setPorcentaje7(p7);
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3,long n4,double p4,long n5,double p5,long n6,double p6,long n7,double p7,long n8,double p8){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
		this.setNumero4(n4);
		this.setPorcentaje4(p4);
		this.setNumero5(n5);
		this.setPorcentaje5(p5);
		this.setNumero6(n6);
		this.setPorcentaje6(p6);
		this.setNumero7(n7);
		this.setPorcentaje7(p7);
		this.setNumero8(n8);
		this.setPorcentaje8(p8);
	}
	public EstadisticasBasicas(String t,long n,double p,long n2,double p2,long n3,double p3,long n4,double p4,long n5,double p5,long n6,double p6,long n7,double p7,long n8,double p8,long n9,double p9){
		this.setTipo(t);
		this.setNumero(n);
		this.setPorcentaje(p);
		this.setNumero2(n2);
		this.setPorcentaje2(p2);
		this.setNumero3(n3);
		this.setPorcentaje3(p3);
		this.setNumero4(n4);
		this.setPorcentaje4(p4);
		this.setNumero5(n5);
		this.setPorcentaje5(p5);
		this.setNumero6(n6);
		this.setPorcentaje6(p6);
		this.setNumero7(n7);
		this.setPorcentaje7(p7);
		this.setNumero8(n8);
		this.setPorcentaje8(p8);
		this.setNumero9(n9);
		this.setPorcentaje9(p9);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public long getNumero2() {
		return numero2;
	}
	public void setNumero2(long numero2) {
		this.numero2 = numero2;
	}
	public double getPorcentaje2() {
		return porcentaje2;
	}
	public void setPorcentaje2(double porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}
	public long getNumero3() {
		return numero3;
	}
	public void setNumero3(long numero3) {
		this.numero3 = numero3;
	}
	public double getPorcentaje3() {
		return porcentaje3;
	}
	public void setPorcentaje3(double porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}
	public long getNumero4() {
		return numero4;
	}
	public void setNumero4(long numero4) {
		this.numero4 = numero4;
	}
	public double getPorcentaje4() {
		return porcentaje4;
	}
	public void setPorcentaje4(double porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}
	public long getNumero5() {
		return numero5;
	}
	public void setNumero5(long numero5) {
		this.numero5 = numero5;
	}
	public double getPorcentaje5() {
		return porcentaje5;
	}
	public void setPorcentaje5(double porcentaje5) {
		this.porcentaje5 = porcentaje5;
	}
	public long getNumero6() {
		return numero6;
	}
	public void setNumero6(long numero6) {
		this.numero6 = numero6;
	}
	public double getPorcentaje6() {
		return porcentaje6;
	}
	public void setPorcentaje6(double porcentaje6) {
		this.porcentaje6 = porcentaje6;
	}
	public long getNumero7() {
		return numero7;
	}
	public void setNumero7(long numero7) {
		this.numero7 = numero7;
	}
	public double getPorcentaje7() {
		return porcentaje7;
	}
	public void setPorcentaje7(double porcentaje7) {
		this.porcentaje7 = porcentaje7;
	}
	public long getNumero8() {
		return numero8;
	}
	public void setNumero8(long numero8) {
		this.numero8 = numero8;
	}
	public double getPorcentaje8() {
		return porcentaje8;
	}
	public void setPorcentaje8(double porcentaje8) {
		this.porcentaje8 = porcentaje8;
	}
	public long getNumero9() {
		return numero9;
	}
	public void setNumero9(long numero9) {
		this.numero9 = numero9;
	}
	public double getPorcentaje9() {
		return porcentaje9;
	}
	public void setPorcentaje9(double porcentaje9) {
		this.porcentaje9 = porcentaje9;
	}
	public long getSuma1() {
		return suma1;
	}
	public void setSuma1(long suma1) {
		this.suma1 = suma1;
	}
	public long getSuma2() {
		return suma2;
	}
	public void setSuma2(long suma2) {
		this.suma2 = suma2;
	}
	public long getSuma3() {
		return suma3;
	}
	public void setSuma3(long suma3) {
		this.suma3 = suma3;
	}
	

	
	
}
