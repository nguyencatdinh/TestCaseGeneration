Program(
	FuncDecl(
		test03
		ParaList(
			Para(
				X
				TypeList(
					Int
					EmptyTypeList()
				)
			)
			ParaList(
				Para(
					Y
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
				IfThenElseStmt(
					BinExpr(
						BinExpr(
							VarExpr(
								X
							)
							<=
							IntLiteral(
								0
							)
						)
						||
						BinExpr(
							VarExpr(
								Y
							)
							<=
							IntLiteral(
								0
							)
						)
					)
					CompStmt(
						StmtList(
							RetStmt(
								UnaryExpr(
									-
									IntLiteral(
										1
									)
								)
							)
							EmptyStmtList()
						)
					)
					IfThenElseStmt(
						BinExpr(
							VarExpr(
								X
							)
							>
							VarExpr(
								Y
							)
						)
						CompStmt(
							StmtList(
								RetStmt(
									VarExpr(
										X
									)
								)
								EmptyStmtList()
							)
						)
						CompStmt(
							StmtList(
								RetStmt(
									VarExpr(
										Y
									)
								)
								EmptyStmtList()
							)
						)
					)
				)
				EmptyStmtList()
			)
		)
	)
	EmptyDeclarationList()
)