import sympy as sp

t = sp.symbols('t')
s = t**3 - 6*t**2 + 9*t + 5
v = sp.diff(s, t)
a = sp.diff(v, t)
rest_times = sp.solve(sp.Eq(v, 0), t)
displacement = sp.integrate(v, (t, 1, 4))

print("Velocity function v(t):", v)
print("Acceleration function a(t):", a)
print("Time(s) when momentarily at rest:", rest_times)
print("Displacement from t=1 to t=4:", displacement)