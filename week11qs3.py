import sympy as sp

x, y = sp.symbols('x y')
expr = (x + y)**2 + (x - y)**2
expanded = sp.expand(expr)
factored = sp.factor(x**2 - 5*x + 6)
simplified = sp.simplify((x**3 - x) / (x + 1))

q = sp.symbols('q')
eq = sp.Eq(q**2 - 10*q + 21, 0)
solution = sp.solve(eq, q)

print("Expanded Expression:", expanded)
print("Factored Expression:", factored)
print("Simplified Expression:", simplified)
print("Production Quantity Solutions:", solution)