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
						result
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
					IfThenElseStmt(
						BinExpr(
							VarExpr(
								n
							)
							>
							IntLiteral(
								0
							)
						)
						ExprStmt(
							BinExpr(
								VarExpr(
									result
								)
								=
								BinExpr(
									CallExpr(
										sin
										ExprList(
											IntLiteral(
												30
											)
											EmptyExprList()
										)
									)
									+
									IntLiteral(
										4
									)
								)
							)
						)
						ExprStmt(
							BinExpr(
								VarExpr(
									result
								)
								=
								BinExpr(
									CallExpr(
										cos
										ExprList(
											IntLiteral(
												60
											)
											EmptyExprList()
										)
									)
									-
									IntLiteral(
										6
									)
								)
							)
						)
					)
					StmtList(
						RetStmt(
							VarExpr(
								result
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
