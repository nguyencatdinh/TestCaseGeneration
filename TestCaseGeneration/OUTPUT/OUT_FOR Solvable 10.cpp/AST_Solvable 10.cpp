Program(
	FuncDecl(
		Tomorrow
		ParaList(
			Para(
				day
				TypeList(
					Int
					EmptyTypeList()
				)
			)
			ParaList(
				Para(
					date
					TypeList(
						Int
						EmptyTypeList()
					)
				)
				ParaList(
					Para(
						month
						TypeList(
							Int
							EmptyTypeList()
						)
					)
					ParaList(
						Para(
							year
							TypeList(
								Int
								EmptyTypeList()
							)
						)
						EmptyParaList()
					)
				)
			)
		)
		TypeList(
			Void
			EmptyTypeList()
		)
		CompStmt(
			StmtList(
				DeclarationStmt(
					VarDecl(
						next_day
						TypeList(
							Int
							EmptyTypeList()
						)
					)
					EmptyDeclarationList()
				)
				StmtList(
					DeclarationStmt(
						VarDecl(
							next_date
							TypeList(
								Int
								EmptyTypeList()
							)
						)
						EmptyDeclarationList()
					)
					StmtList(
						DeclarationStmt(
							VarDecl(
								next_month
								TypeList(
									Int
									EmptyTypeList()
								)
							)
							EmptyDeclarationList()
						)
						StmtList(
							DeclarationStmt(
								VarDecl(
									next_year
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
											next_day
										)
										=
										VarExpr(
											day
										)
									)
								)
								StmtList(
									ExprStmt(
										BinExpr(
											VarExpr(
												next_date
											)
											=
											VarExpr(
												date
											)
										)
									)
									StmtList(
										ExprStmt(
											BinExpr(
												VarExpr(
													next_month
												)
												=
												VarExpr(
													month
												)
											)
										)
										StmtList(
											ExprStmt(
												BinExpr(
													VarExpr(
														next_year
													)
													=
													VarExpr(
														year
													)
												)
											)
											StmtList(
												IfThenElseStmt(
													BinExpr(
														BinExpr(
															BinExpr(
																BinExpr(
																	BinExpr(
																		BinExpr(
																			VarExpr(
																				day
																			)
																			>=
																			IntLiteral(
																				2
																			)
																		)
																		&&
																		BinExpr(
																			VarExpr(
																				day
																			)
																			<=
																			IntLiteral(
																				8
																			)
																		)
																	)
																	&&
																	BinExpr(
																		VarExpr(
																			date
																		)
																		>=
																		IntLiteral(
																			1
																		)
																	)
																)
																&&
																BinExpr(
																	VarExpr(
																		date
																	)
																	<=
																	IntLiteral(
																		31
																	)
																)
															)
															&&
															BinExpr(
																VarExpr(
																	month
																)
																>=
																IntLiteral(
																	1
																)
															)
														)
														&&
														BinExpr(
															VarExpr(
																month
															)
															<=
															IntLiteral(
																12
															)
														)
													)
													CompStmt(
														StmtList(
															IfThenElseStmt(
																BinExpr(
																	VarExpr(
																		day
																	)
																	==
																	IntLiteral(
																		8
																	)
																)
																ExprStmt(
																	BinExpr(
																		VarExpr(
																			next_day
																		)
																		=
																		IntLiteral(
																			2
																		)
																	)
																)
																ExprStmt(
																	BinExpr(
																		VarExpr(
																			next_day
																		)
																		=
																		BinExpr(
																			VarExpr(
																				day
																			)
																			+
																			IntLiteral(
																				1
																			)
																		)
																	)
																)
															)
															StmtList(
																IfThenElseStmt(
																	BinExpr(
																		BinExpr(
																			VarExpr(
																				month
																			)
																			==
																			IntLiteral(
																				12
																			)
																		)
																		&&
																		BinExpr(
																			VarExpr(
																				date
																			)
																			==
																			IntLiteral(
																				31
																			)
																		)
																	)
																	CompStmt(
																		StmtList(
																			ExprStmt(
																				BinExpr(
																					VarExpr(
																						next_date
																					)
																					=
																					IntLiteral(
																						1
																					)
																				)
																			)
																			StmtList(
																				ExprStmt(
																					BinExpr(
																						VarExpr(
																							next_month
																						)
																						=
																						IntLiteral(
																							1
																						)
																					)
																				)
																				StmtList(
																					ExprStmt(
																						BinExpr(
																							VarExpr(
																								next_year
																							)
																							=
																							BinExpr(
																								VarExpr(
																									year
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
																	IfThenElseStmt(
																		BinExpr(
																			BinExpr(
																				VarExpr(
																					date
																				)
																				==
																				IntLiteral(
																					28
																				)
																			)
																			&&
																			BinExpr(
																				VarExpr(
																					month
																				)
																				==
																				IntLiteral(
																					2
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
																									year
																								)
																								%
																								IntLiteral(
																									4
																								)
																							)
																							==
																							IntLiteral(
																								0
																							)
																						)
																						||
																						BinExpr(
																							BinExpr(
																								VarExpr(
																									year
																								)
																								%
																								IntLiteral(
																									400
																								)
																							)
																							==
																							IntLiteral(
																								0
																							)
																						)
																					)
																					ExprStmt(
																						BinExpr(
																							VarExpr(
																								next_date
																							)
																							=
																							IntLiteral(
																								29
																							)
																						)
																					)
																					CompStmt(
																						StmtList(
																							ExprStmt(
																								BinExpr(
																									VarExpr(
																										next_date
																									)
																									=
																									IntLiteral(
																										1
																									)
																								)
																							)
																							StmtList(
																								ExprStmt(
																									BinExpr(
																										VarExpr(
																											next_month
																										)
																										=
																										BinExpr(
																											VarExpr(
																												month
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
																				EmptyStmtList()
																			)
																		)
																		IfThenElseStmt(
																			BinExpr(
																				BinExpr(
																					VarExpr(
																						date
																					)
																					==
																					IntLiteral(
																						31
																					)
																				)
																				&&
																				BinExpr(
																					BinExpr(
																						BinExpr(
																							BinExpr(
																								BinExpr(
																									BinExpr(
																										VarExpr(
																											month
																										)
																										==
																										IntLiteral(
																											1
																										)
																									)
																									||
																									BinExpr(
																										VarExpr(
																											month
																										)
																										==
																										IntLiteral(
																											3
																										)
																									)
																								)
																								||
																								BinExpr(
																									VarExpr(
																										month
																									)
																									==
																									IntLiteral(
																										5
																									)
																								)
																							)
																							||
																							BinExpr(
																								VarExpr(
																									month
																								)
																								==
																								IntLiteral(
																									7
																								)
																							)
																						)
																						||
																						BinExpr(
																							VarExpr(
																								month
																							)
																							==
																							IntLiteral(
																								8
																							)
																						)
																					)
																					||
																					BinExpr(
																						VarExpr(
																							month
																						)
																						==
																						IntLiteral(
																							10
																						)
																					)
																				)
																			)
																			CompStmt(
																				StmtList(
																					ExprStmt(
																						BinExpr(
																							VarExpr(
																								next_date
																							)
																							=
																							IntLiteral(
																								1
																							)
																						)
																					)
																					StmtList(
																						ExprStmt(
																							BinExpr(
																								VarExpr(
																									next_month
																								)
																								=
																								BinExpr(
																									VarExpr(
																										month
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
																			IfThenElseStmt(
																				BinExpr(
																					BinExpr(
																						VarExpr(
																							date
																						)
																						==
																						IntLiteral(
																							29
																						)
																					)
																					&&
																					BinExpr(
																						VarExpr(
																							month
																						)
																						==
																						IntLiteral(
																							2
																						)
																					)
																				)
																				CompStmt(
																					StmtList(
																						ExprStmt(
																							BinExpr(
																								VarExpr(
																									next_date
																								)
																								=
																								IntLiteral(
																									1
																								)
																							)
																						)
																						StmtList(
																							ExprStmt(
																								BinExpr(
																									VarExpr(
																										next_month
																									)
																									=
																									BinExpr(
																										VarExpr(
																											month
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
																				IfThenElseStmt(
																					BinExpr(
																						BinExpr(
																							VarExpr(
																								date
																							)
																							==
																							IntLiteral(
																								30
																							)
																						)
																						&&
																						BinExpr(
																							BinExpr(
																								BinExpr(
																									BinExpr(
																										VarExpr(
																											month
																										)
																										==
																										IntLiteral(
																											4
																										)
																									)
																									||
																									BinExpr(
																										VarExpr(
																											month
																										)
																										==
																										IntLiteral(
																											6
																										)
																									)
																								)
																								||
																								BinExpr(
																									VarExpr(
																										month
																									)
																									==
																									IntLiteral(
																										9
																									)
																								)
																							)
																							||
																							BinExpr(
																								VarExpr(
																									month
																								)
																								==
																								IntLiteral(
																									11
																								)
																							)
																						)
																					)
																					CompStmt(
																						StmtList(
																							ExprStmt(
																								BinExpr(
																									VarExpr(
																										next_date
																									)
																									=
																									IntLiteral(
																										1
																									)
																								)
																							)
																							StmtList(
																								ExprStmt(
																									BinExpr(
																										VarExpr(
																											next_month
																										)
																										=
																										BinExpr(
																											VarExpr(
																												month
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
																					ExprStmt(
																						BinExpr(
																							VarExpr(
																								next_date
																							)
																							+
																							IntLiteral(
																								1
																							)
																						)
																					)
																				)
																			)
																		)
																	)
																)
																EmptyStmtList()
															)
														)
													)
													CompStmt(
														StmtList(
															ExprStmt(
																CallExpr(
																	printf
																	ExprList(
																		StringLiteral(
																			"Invalid input"
																		)
																		EmptyExprList()
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
								)
							)
						)
					)
				)
			)
		)
	)
	EmptyDeclarationList()
)
