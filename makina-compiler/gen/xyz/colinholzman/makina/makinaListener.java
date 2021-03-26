// Generated from C:/Users/Colin/Documents/makina/makina-compiler/src\makina.g4 by ANTLR 4.9.1
package xyz.colinholzman.makina;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link makinaParser}.
 */
public interface makinaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link makinaParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(makinaParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(makinaParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(makinaParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(makinaParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(makinaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(makinaParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code entryHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterEntryHandler(makinaParser.EntryHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code entryHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitEntryHandler(makinaParser.EntryHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exitHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterExitHandler(makinaParser.ExitHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exitHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitExitHandler(makinaParser.ExitHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eventHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterEventHandler(makinaParser.EventHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eventHandler}
	 * labeled alternative in {@link makinaParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitEventHandler(makinaParser.EventHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(makinaParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(makinaParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link makinaParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(makinaParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link makinaParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(makinaParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultTransition}
	 * labeled alternative in {@link makinaParser#target}.
	 * @param ctx the parse tree
	 */
	void enterDefaultTransition(makinaParser.DefaultTransitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultTransition}
	 * labeled alternative in {@link makinaParser#target}.
	 * @param ctx the parse tree
	 */
	void exitDefaultTransition(makinaParser.DefaultTransitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code externalTransition}
	 * labeled alternative in {@link makinaParser#target}.
	 * @param ctx the parse tree
	 */
	void enterExternalTransition(makinaParser.ExternalTransitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code externalTransition}
	 * labeled alternative in {@link makinaParser#target}.
	 * @param ctx the parse tree
	 */
	void exitExternalTransition(makinaParser.ExternalTransitionContext ctx);
}