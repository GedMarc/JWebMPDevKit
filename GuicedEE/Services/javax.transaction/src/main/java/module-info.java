module java.transaction {
	requires static java.rmi;
	requires java.transaction.xa;

	exports javax.transaction;
}
