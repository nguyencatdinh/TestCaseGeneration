Program(
	FuncDecl(
		foo
		ParaList(
			Para(
				N
				TypeList(
					Int
					EmptyTypeList()
				)
			)
			EmptyParaList()
		)
		TypeList(
			Int
			EmptyTypeList()
		)
		CompStmt(
			StmtList(
				DeclarationStmt(
					VarDecl(
						i
						TypeList(
							Int
							EmptyTypeList()
						)
					)
					EmptyDeclarationList()
				)
				StmtList(
					ExprStmt(
						BinExpr(
							VarExpr(
								i
							)
							=
							IntLiteral(
								1
							)
						)
					)
					StmtList(
						DeclarationStmt(
							VarDecl(
								gt
								TypeList(
									Int
									EmptyTypeList()
								)
								VarInitializer(
									IntLiteral(
										1
									)
								)
							)
							EmptyDeclarationList()
						)
						StmtList(
							WhileStmt(
								BinExpr(
									VarExpr(
										i
									)
									<=
									VarExpr(
										N
									)
								)
								CompStmt(
									StmtList(
										ExprStmt(
											BinExpr(
												VarExpr(
													gt
												)
												=
												BinExpr(
													VarExpr(
														gt
													)
													*
													VarExpr(
														i
													)
												)
											)
										)
										StmtList(
											ExprStmt(
												BinExpr(
													VarExpr(
														i
													)
													=
													BinExpr(
														VarExpr(
															i
														)
														+
														IntLiteral(
															1
														)
													)
												)
											)
											EmptyStmtList()
										)
									)
								)
							)
							StmtList(
								RetStmt(
									VarExpr(
										gt
									)
								)
								EmptyStmtList()
							)
						)
					)
				)
			)
		)
	)
	EmptyDeclarationList()
)
