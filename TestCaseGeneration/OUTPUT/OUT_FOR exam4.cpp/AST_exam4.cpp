Program(
	FuncDecl(
		f
		ParaList(
			Para(
				a
				TypeList(
					Float
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
						x
						TypeList(
							Int
							EmptyTypeList()
						)
						VarInitializer(
							IntLiteral(
								5
							)
						)
					)
					EmptyDeclarationList()
				)
				StmtList(
					DeclarationStmt(
						VarDecl(
							y
							TypeList(
								Float
								EmptyTypeList()
							)
							VarInitializer(
								BinExpr(
									VarExpr(
										x
									)
									/
									IntLiteral(
										2
									)
								)
							)
						)
						EmptyDeclarationList()
					)
					StmtList(
						IfThenStmt(
							BinExpr(
								VarExpr(
									a
								)
								==
								VarExpr(
									y
								)
							)
							CompStmt(
								StmtList(
									ExprStmt(
										BinExpr(
											VarExpr(
												y
											)
											=
											BinExpr(
												VarExpr(
													y
												)
												+
												IntLiteral(
													1
												)
											)
										)
									)
									StmtList(
										ExprStmt(
											BinExpr(
												VarExpr(
													x
												)
												=
												BinExpr(
													BinExpr(
														IntLiteral(
															3
														)
														*
														BinExpr(
															VarExpr(
																y
															)
															+
															IntLiteral(
																6
															)
														)
													)
													-
													BinExpr(
														IntLiteral(
															8
														)
														*
														VarExpr(
															x
														)
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
									x
								)
							)
							EmptyStmtList()
						)
					)
				)
			)
		)
	)
	EmptyDeclarationList()
)
