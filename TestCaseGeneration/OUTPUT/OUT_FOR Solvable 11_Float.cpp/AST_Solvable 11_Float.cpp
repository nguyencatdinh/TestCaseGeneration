Program(
	FuncDecl(
		triangle
		ParaList(
			Para(
				a
				TypeList(
					Float
					EmptyTypeList()
				)
			)
			ParaList(
				Para(
					b
					TypeList(
						Float
						EmptyTypeList()
					)
				)
				ParaList(
					Para(
						c
						TypeList(
							Float
							EmptyTypeList()
						)
					)
					EmptyParaList()
				)
			)
		)
		TypeList(
			Int
			EmptyTypeList()
		)
		CompStmt(
			StmtList(
				DeclarationStmt(
					VarDecl(
						triangle
						TypeList(
							Int
							EmptyTypeList()
						)
					)
					EmptyDeclarationList()
				)
				StmtList(
					IfThenElseStmt(
						BinExpr(
							BinExpr(
								BinExpr(
									BinExpr(
										VarExpr(
											a
										)
										+
										VarExpr(
											b
										)
									)
									>
									VarExpr(
										c
									)
								)
								&&
								BinExpr(
									BinExpr(
										VarExpr(
											b
										)
										+
										VarExpr(
											c
										)
									)
									>
									VarExpr(
										a
									)
								)
							)
							&&
							BinExpr(
								BinExpr(
									VarExpr(
										c
									)
									+
									VarExpr(
										a
									)
								)
								>
								VarExpr(
									b
								)
							)
						)
						CompStmt(
							StmtList(
								IfThenElseStmt(
									BinExpr(
										BinExpr(
											BinExpr(
												VarExpr(
													a
												)
												!=
												VarExpr(
													b
												)
											)
											&&
											BinExpr(
												VarExpr(
													b
												)
												!=
												VarExpr(
													c
												)
											)
										)
										&&
										BinExpr(
											VarExpr(
												c
											)
											!=
											VarExpr(
												a
											)
										)
									)
									CompStmt(
										StmtList(
											ExprStmt(
												BinExpr(
													VarExpr(
														triangle
													)
													=
													IntLiteral(
														1
													)
												)
											)
											EmptyStmtList()
										)
									)
									CompStmt(
										StmtList(
											IfThenElseStmt(
												BinExpr(
													BinExpr(
														BinExpr(
															BinExpr(
																VarExpr(
																	a
																)
																==
																VarExpr(
																	b
																)
															)
															&&
															BinExpr(
																VarExpr(
																	b
																)
																!=
																VarExpr(
																	c
																)
															)
														)
														||
														BinExpr(
															BinExpr(
																VarExpr(
																	b
																)
																==
																VarExpr(
																	c
																)
															)
															&&
															BinExpr(
																VarExpr(
																	c
																)
																!=
																VarExpr(
																	a
																)
															)
														)
													)
													||
													BinExpr(
														BinExpr(
															VarExpr(
																c
															)
															==
															VarExpr(
																a
															)
														)
														&&
														BinExpr(
															VarExpr(
																a
															)
															!=
															VarExpr(
																b
															)
														)
													)
												)
												CompStmt(
													StmtList(
														ExprStmt(
															BinExpr(
																VarExpr(
																	triangle
																)
																=
																IntLiteral(
																	2
																)
															)
														)
														EmptyStmtList()
													)
												)
												CompStmt(
													StmtList(
														ExprStmt(
															BinExpr(
																VarExpr(
																	triangle
																)
																=
																IntLiteral(
																	3
																)
															)
														)
														EmptyStmtList()
													)
												)
											)
											EmptyStmtList()
										)
									)
								)
								EmptyStmtList()
							)
						)
						ExprStmt(
							BinExpr(
								VarExpr(
									triangle
								)
								=
								IntLiteral(
									0
								)
							)
						)
					)
					StmtList(
						RetStmt(
							VarExpr(
								triangle
							)
						)
						EmptyStmtList()
					)
				)
			)
		)
	)
	EmptyDeclarationList()
)