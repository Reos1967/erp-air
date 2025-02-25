import pandas as pd
import streamlit as st
from PIL import Image
from matplotlib import pyplot
import seaborn as sns

def generarMenu():
    with st.sidebar:
        col1, col2 = st.columns(2)
        with col1: 
            imagen = Image.open("Media\wplay.jpg")
            st.image(imagen, use_container_width=False, width=80)
        with col2:
            st.header("Liga Betplay 2025")
            

        st.page_link("app.py", label="Home", icon="🏚️")
        st.page_link("Pages\informe.py", label="infor", icon="📝")


def tablaGoles(df, titulo):
    df2 = pd.DataFrame(df)
    """
    Parámetros:
    df (DataFrame): DataFrame con los datos de los goles.
    titulo (str): Título a mostrar en la interfaz (opcional).
    """
    col1, col2, col3 = st.columns([0.5, 5, 0.5], 
                                  vertical_alignment="top")

    with col2:
        st.markdown(titulo)
        df2.set_index("Local", inplace=True)
        st.write(df2, unsafe_allow_html=False)
        
        st.markdown("Grafico de Barras")
        sns.set_style("whitegrid")
        
        total = df2.groupby("Local")[["Goles Locales", "Goles Visitantes"]].sum()
        
        goles = pd.DataFrame(total)
        goles["Goles Total"] = goles["Goles Locales"] + goles["Goles Visitantes"]
        goles = goles.reset_index()
        goles.set_index("Local", inplace=True)
        st.write(goles, unsafe_allow_html=False)
        
        resultado = goles.groupby(["Local"]).sum()
        resultado.plot(kind="bar", figsize=(20,20))
        pyplot.tight_layout()
        st.pyplot(pyplot)
        
        