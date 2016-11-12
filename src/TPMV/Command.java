p a c k a g e   T P M V ; 
 
 / * * 
   *   C l a s e   q u e   r e p r e s e n t a   l o s   c o m a n d o s   a d m i t i d o s . 
   * / 
 p u b l i c   c l a s s   C o m m a n d   { 
 
 	 p r i v a t e   f i n a l   E N U M _ C O M M A N D   c o m m a n d ; 
 	 p r i v a t e   B y t e C o d e   i n s t r u c t i o n ; 
 	 p r i v a t e   i n t   r e p l a c e   =   - 1 ; 
 
 	 / * * 
 	   *   C o n s t r u c t o r   d e   l a   c l a s e . 
 	   *   
 	   *   @ p a r a m   c o m m a n d 
 	   *                         C o m a n d o   c o n   e l   q u e   c o n s t r u i m o s   l a   c l a s e . 
 	   * / 
 	 p u b l i c   C o m m a n d ( E N U M _ C O M M A N D   c o m m a n d )   { 
 	 	 t h i s . c o m m a n d   =   c o m m a n d ; 
 	 } 
 
 	 / * * 
 	   *   C o n s t r u c t o r   d e   l a   c l a s e . 
 	   *   
 	   *   @ p a r a m   c o m m a n d 
 	   *                         C o m a n d o   c o n   e l   q u e   c o n s t r u i m o s   l a   c l a s e . 
 	   *   @ p a r a m   i n s t r u c t i o n 
 	   *                         B y t e C o d e   a s o c i a d o   a l   c o m a n d o . 
 	   * / 
 	 p u b l i c   C o m m a n d ( E N U M _ C O M M A N D   c o m m a n d ,   B y t e C o d e   i n s t r u c t i o n )   { 
 	 	 t h i s . c o m m a n d   =   c o m m a n d ; 
 	 	 t h i s . i n s t r u c t i o n   =   i n s t r u c t i o n ; 
 	 } 
 
 	 / * * 
 	   *   C o n s t r u c t o r   d e   l a   c l a s e . 
 	   *   
 	   *   @ p a r a m   c o m m a n d 
 	   *                         C o m a n d o   c o n   e l   q u e   c o n s t r u i m o s   l a   c l a s e . 
 	   *   @ p a r a m   r e p l a c e 
 	   *                         P a r a m e t r o   a s o c i a d o   a l   c o m a n d o . 
 	   * / 
 	 p u b l i c   C o m m a n d ( E N U M _ C O M M A N D   c o m m a n d ,   i n t   r e p l a c e )   { 
 	 	 t h i s . c o m m a n d   =   c o m m a n d ; 
 	 	 t h i s . r e p l a c e   =   r e p l a c e ; 
 	 } 
 
 	 / * * 
 	   *   F u n c i � n   q u e   r e a l i z a   l a s   l l a m a d a s   a   l o s   m � t o d o s   a s o c i a d o s   a   c a d a   c o m a n d o . 
 	   *   
 	   *   @ p a r a m   e n g i n e 
 	   *                         I n s t a n c i a   e n   l a   q u e   s e   e j e c u t a n   l o s   c o m a n d o s . 
 	   *   @ r e t u r n   � x i t o   o   f r a c a s o   d e   l a   o p e r a c i � n . 
 	   * / 
 	 p u b l i c   b o o l e a n   e x e c u t e ( E n g i n e   e n g i n e )   { 
 	 	 s w i t c h   ( c o m m a n d )   { 
 	 	 c a s e   H E L P : 
 	 	 	 r e t u r n   E n g i n e . e x e c u t e H e l p ( ) ; 
 	 	 c a s e   Q U I T : 
 	 	 	 r e t u r n   e n g i n e . e x e c u t e Q u i t ( ) ; 
 	 	 c a s e   N E W I N S T : 
 	 	 	 r e t u r n   e n g i n e . e x e c u t e N e w I n s t ( i n s t r u c t i o n ) ; 
 	 	 c a s e   R U N : 
 	 	 	 r e t u r n   e n g i n e . e x c u t e C o m m a n d R u n ( ) ; 
 	 	 c a s e   R E S E T : 
 	 	 	 r e t u r n   e n g i n e . e x e c u t e R e s e t ( ) ; 
 	 	 c a s e   R E P L A C E : 
 	 	 	 r e t u r n   e n g i n e . e x e c u t e R e p l a c e ( r e p l a c e ) ; 
 	 	 } 
 	 	 r e t u r n   f a l s e ; 
 	 } 
 
 	 p u b l i c   S t r i n g   t o S t r i n g ( )   { 
 	 	 S t r i n g   r e s u l t a d o   =   t h i s . c o m m a n d . t o S t r i n g ( ) ; 
 	 	 i f   ( i n s t r u c t i o n   ! =   n u l l ) 
 	 	 	 r e s u l t a d o   + =   "   "   +   i n s t r u c t i o n . t o S t r i n g ( ) ; 
 	 	 i f   ( r e p l a c e   >   - 1 ) 
 	 	 	 r e s u l t a d o   + =   "   "   +   r e p l a c e ; 
 	 	 r e t u r n   r e s u l t a d o ; 
 	 } 
 } 
 