Program(
	FuncDecl(
		test02
		ParaList(
			Para(
				x
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
				IfThenStmt(
					BinExpr(
						VarExpr(
							x
						)
						>
						IntLiteral(
							5
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
									BinExpr(
										VarExpr(
											x
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
				StmtList(
					DeclarationStmt(
						VarDecl(
							y
							TypeList(
								Int
								EmptyTypeList()
							)
							VarInitializer(
								BinExpr(
									IntLiteral(
										2
									)
									*
									VarExpr(
										x
									)
								)
							)
						)
						EmptyDeclarationList()
					)
					StmtList(
						IfThenElseStmt(
							BinExpr(
								VarExpr(
									y
								)
								==
								IntLiteral(
									3
								)
							)
							RetStmt(
								IntLiteral(
									1
								)
							)
							RetStmt(
								IntLiteral(
									2
								)
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
