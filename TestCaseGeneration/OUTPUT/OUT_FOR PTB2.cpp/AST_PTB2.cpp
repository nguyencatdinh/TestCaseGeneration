Program(
	FuncDecl(
		ptb2
		ParaList(
			Para(
				a
				TypeList(
					Double
					EmptyTypeList()
				)
			)
			ParaList(
				Para(
					b
					TypeList(
						Double
						EmptyTypeList()
					)
				)
				ParaList(
					Para(
						c
						TypeList(
							Double
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
				IfThenElseStmt(
					BinExpr(
						VarExpr(
							a
						)
						!=
						IntLiteral(
							0
						)
					)
					CompStmt(
						StmtList(
							DeclarationStmt(
								VarDecl(
									delta
									TypeList(
										Double
										EmptyTypeList()
									)
									VarInitializer(
										BinExpr(
											CallExpr(
												pow
												ExprList(
													VarExpr(
														b
													)
													ExprList(
														IntLiteral(
															2
														)
														EmptyExprList()
													)
												)
											)
											-
											BinExpr(
												BinExpr(
													IntLiteral(
														4
													)
													*
													VarExpr(
														a
													)
												)
												*
												VarExpr(
													c
												)
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
											delta
										)
										>=
										IntLiteral(
											0
										)
									)
									CompStmt(
										StmtList(
											IfThenElseStmt(
												BinExpr(
													VarExpr(
														delta
													)
													>
													IntLiteral(
														0
													)
												)
												CompStmt(
													StmtList(
														RetStmt(
															IntLiteral(
																2
															)
														)
														EmptyStmtList()
													)
												)
												CompStmt(
													StmtList(
														RetStmt(
															IntLiteral(
																1
															)
														)
														EmptyStmtList()
													)
												)
											)
											EmptyStmtList()
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
					RetStmt(
						IntLiteral(
							1
						)
					)
				)
				EmptyStmtList()
			)
		)
	)
	EmptyDeclarationList()
)
