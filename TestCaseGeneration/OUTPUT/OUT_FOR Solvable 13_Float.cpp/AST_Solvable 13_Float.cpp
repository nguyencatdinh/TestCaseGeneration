Program(
	FuncDecl(
		ucln
		ParaList(
			Para(
				n
				TypeList(
					Int
					EmptyTypeList()
				)
			)
			ParaList(
				Para(
					m
					TypeList(
						Int
						EmptyTypeList()
					)
				)
				EmptyParaList()
			)
		)
		TypeList(
			Int
			EmptyTypeList()
		)
		CompStmt(
			StmtList(
				WhileStmt(
					BinExpr(
						BinExpr(
							VarExpr(
								n
							)
							!=
							IntLiteral(
								0
							)
						)
						&&
						BinExpr(
							VarExpr(
								m
							)
							!=
							IntLiteral(
								0
							)
						)
					)
					CompStmt(
						StmtList(
							IfThenElseStmt(
								BinExpr(
									VarExpr(
										n
									)
									>
									VarExpr(
										m
									)
								)
								CompStmt(
									StmtList(
										ExprStmt(
											BinExpr(
												VarExpr(
													n
												)
												-=
												VarExpr(
													m
												)
											)
										)
										EmptyStmtList()
									)
								)
								ExprStmt(
									BinExpr(
										VarExpr(
											m
										)
										-=
										VarExpr(
											n
										)
									)
								)
							)
							EmptyStmtList()
						)
					)
				)
				StmtList(
					IfThenElseStmt(
						BinExpr(
							VarExpr(
								n
							)
							==
							IntLiteral(
								0
							)
						)
						CompStmt(
							StmtList(
								RetStmt(
									VarExpr(
										m
									)
								)
								EmptyStmtList()
							)
						)
						CompStmt(
							StmtList(
								RetStmt(
									VarExpr(
										n
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
	)
	EmptyDeclarationList()
)
