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
				IfThenElseStmt(
					BinExpr(
						CallExpr(
							sin
							ExprList(
								VarExpr(
									n
								)
								EmptyExprList()
							)
						)
						>
						IntLiteral(
							0
						)
					)
					RetStmt(
						IntLiteral(
							1
						)
					)
					RetStmt(
						IntLiteral(
							0
						)
					)
				)
				EmptyStmtList()
			)
		)
	)
	EmptyDeclarationList()
)
