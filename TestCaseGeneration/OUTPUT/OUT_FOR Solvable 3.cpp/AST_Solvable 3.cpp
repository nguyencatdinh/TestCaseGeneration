Program(
	FuncDecl(
		foo
		ParaList(
			Para(
				n
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
						x
						TypeList(
							Int
							EmptyTypeList()
						)
						VarInitializer(
							IntLiteral(
								3
							)
						)
					)
					EmptyDeclarationList()
				)
				StmtList(
					DeclarationStmt(
						VarDecl(
							i
							TypeList(
								Int
								EmptyTypeList()
							)
							VarInitializer(
								IntLiteral(
									0
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
								<
								VarExpr(
									n
								)
							)
							CompStmt(
								StmtList(
									IfThenElseStmt(
										BinExpr(
											BinExpr(
												VarExpr(
													i
												)
												%
												IntLiteral(
													2
												)
											)
											==
											IntLiteral(
												1
											)
										)
										CompStmt(
											StmtList(
												ExprStmt(
													BinExpr(
														VarExpr(
															x
														)
														=
														IntLiteral(
															5
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
															x
														)
														=
														IntLiteral(
															7
														)
													)
												)
												EmptyStmtList()
											)
										)
									)
									StmtList(
										ExprStmt(
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
